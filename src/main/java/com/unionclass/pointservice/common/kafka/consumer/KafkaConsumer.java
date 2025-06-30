package com.unionclass.pointservice.common.kafka.consumer;

import com.unionclass.pointservice.common.kafka.event.MemberCreatedEvent;
import com.unionclass.pointservice.domain.memberpoint.application.MemberPointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final MemberPointService memberPointService;

    @KafkaListener(
            topics = "member-created",
            groupId = "point-group",
            containerFactory = "memberCreatedEventListener"
    )
    public void consumeMemberCreatedEvent(
            MemberCreatedEvent memberCreatedEvent,
            ConsumerRecord<String, MemberCreatedEvent> consumerRecord
    ) {
        log.info("회원 생성 이벤트 수신 완료: {}", memberCreatedEvent);
        log.info("회원 생성 이벤트 수신 - topic: {}, partition: {}, offset: {}",
                consumerRecord.topic(), consumerRecord.partition(), consumerRecord.offset());
        memberPointService.initializeMemberPoint(memberCreatedEvent);
    }
}
