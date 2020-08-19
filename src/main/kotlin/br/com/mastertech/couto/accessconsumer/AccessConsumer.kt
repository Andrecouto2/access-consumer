package br.com.mastertech.couto.accessconsumer

import br.com.mastertech.couto.access.models.Access
import br.com.mastertech.couto.util.CSVUtil
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class AccessConsumer {
    @KafkaListener(topics = ["spec4-andre-luis-2"], groupId = "eu123456789")
    fun receiving(@Payload access: Access) {
        if (access.id == Integer(0)) {
            CSVUtil.writeAccessCSV(access.customerId, access.doorId, false)
            System.out.println("Acesso não encontrado para a Porta: " + access.doorId + " do Cliente: " + access.customerId)
        } else {
            CSVUtil.writeAccessCSV(access.customerId, access.doorId, true)
            System.out.println("Acesso encontrado para a Porta: " + access.doorId + " do Cliente: " + access.customerId)
        }
    }
}