package kafka.sample.springKafka.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaServiceTemplate {
	@Autowired
	private KafkaTemplate<String, String> template;

	public void send(String key, String value) {
		template.send(key, value).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println(result);

			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println(ex.getMessage());

			}

		});
	}

}
