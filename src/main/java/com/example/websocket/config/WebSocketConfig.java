package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    /*
    In the first method,
    we register a websocket endpoint that the clients will use to connect to our websocket server
    클라이언트가 웹 소켓 서버에 연결하는데 사용할 웹 소켓 엔드포인트를 등록합니다.
    */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
        /*
         * withSockJS()
         * 는 웹소켓을 지원하지 않는 브라우저에
         * 폴백 옵션을 활성화하는데 사용됩니다.
         * */
    }

    /*
    You might have noticed the word STOMP in the method name.
    These methods come from Spring frameworks STOMP implementation. STOMP stands for Simple Text Oriented Messaging Protocol.
    It is a messaging protocol that defines the format and rules for data exchange.
    메소드 이름에 STOMP라는 단어가있을 수 있습니다.
    이러한 메소드는 Spring 프레임 워크 STOMP 구현에서 제공됩니다.
    STOMP는 Simple Text Oriented Messaging Protocol의 약어입니다.
    데이터 교환의 형식과 규칙을 정의하는 메시징 프로토콜입니다.
    */



    /*
    In the second method, we’re configuring a message broker that will be used to route messages from one client to another.
    두 번째 방법에서는 한 클라이언트에서 다른 클라이언트로 메시지를 라우팅하는 데 사용될 메시지 브로커를 구성합니다.
    */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // "/ app"로 시작하는 메시지가 메시지 처리 방법으로 라우팅되어야 함을 정의합니다
        registry.setApplicationDestinationPrefixes("/app");
        //"/ topic"으로 시작하는 메시지가 메시지 브로커로 라우팅되도록 정의합니다.
        // 메시지 브로커는 특정 주제를 구독 한 연결된 모든 클라이언트에게 메시지를 브로드 캐스트합니다.
        registry.enableSimpleBroker("/topic");
    }
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        //해당 파라미터의 접두사가 붙은 목적지(구독자)에 메시지를 보낼
//        registry.enableSimpleBroker("/topic");
//
//        //전역적인 주소 접두사 지정 하기싫으면 ("/") 으로 두면 됨
//        registry.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        //"/gs-guide-websocket" 이라는 엔드포인트 추가 등록
//        registry.addEndpoint("/gs-guide-websocket").addInterceptors().withSockJS();
//    }
}
