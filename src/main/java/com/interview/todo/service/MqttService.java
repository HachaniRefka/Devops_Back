package com.interview.todo.service;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.interview.todo.model.FaceInformation;
import com.interview.todo.model.FaceInformationDto;

@Service
public class MqttService {

	@Autowired
	private IMqttClient mqttClient;

	@Autowired
	private SaveFaceService saveFaceService;

	Gson GSON = new Gson();

	public void publish(final String topic, final String payload, int qos, boolean retained)
			throws MqttPersistenceException, MqttException {
		MqttMessage mqttMessage = new MqttMessage();
		mqttMessage.setPayload(payload.getBytes());
		mqttMessage.setQos(qos);
		mqttMessage.setRetained(retained);

		mqttClient.publish(topic, mqttMessage);

		// mqttClient.publish(topic, payload.getBytes(), qos, retained);

		mqttClient.disconnect();
	}

	public void subscribe(final String topic) throws MqttException, InterruptedException {
		System.out.println("Messages received:");

		mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {
			System.out.println(msg.getId() + " -> " + new String(msg.getPayload()));
			try {
				FaceInformationDto face = GSON.fromJson(new String(msg.getPayload()), FaceInformationDto.class);
				System.out.println(face);
				FaceInformation faceInfo = new FaceInformation();
				faceInfo.setFaceName(face.getFaceName());
				this.saveFaceService.addTodo(faceInfo);
			} catch (Exception e) {
				System.out.println(e);
			}

		});
	}

}