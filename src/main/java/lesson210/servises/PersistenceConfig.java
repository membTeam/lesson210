package lesson210.servises;

import lesson210.models.Emploee;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import java.util.UUID;

@Configuration
public class PersistenceConfig {
    static int numINN = 50000;

    @Bean
    public ApplicationListener<BeforeSaveEvent> idGenerator() {
        return event -> {
            var entity = event.getEntity();
            if (entity instanceof Emploee) {
                var objEntity = ((Emploee) entity);
                if (objEntity.getId() == null ){
                    objEntity.setId(UUID.randomUUID().toString() );
                    objEntity.setINN( "6134" + numINN++ + "001");

                }
            }
        };
    }
}
