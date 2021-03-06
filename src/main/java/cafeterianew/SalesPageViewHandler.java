package cafeterianew;

import cafeterianew.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SalesPageViewHandler {


    @Autowired
    private SalesPageRepository salesPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFirstSaled_then_CREATE_1 (@Payload FirstSaled firstSaled) {
        try {
            if (firstSaled.isMe()) {
                // view 객체 생성
                  = new ();
                // view 객체에 이벤트의 Value 를 set 함
                .setProductName(.getProductName());
                .setAmt(.getAmt());
                // view 레파지 토리에 save
                Repository.save();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenSalesAdded_then_UPDATE_1(@Payload SalesAdded salesAdded) {
        try {
            if (salesAdded.isMe()) {
                // view 객체 조회
                List<> List = Repository.findByProductName(.getProductName());
                for(  : List){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    Repository.save();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenSalesSubtracted_then_UPDATE_2(@Payload SalesSubtracted salesSubtracted) {
        try {
            if (salesSubtracted.isMe()) {
                // view 객체 조회
                List<> List = Repository.findByAmt(.getAmt());
                for(  : List){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    Repository.save();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}