/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.config;

/**
 *
 * @author BICHO
 */
import javax.sql.DataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
public class DbDebug {
  @Bean
  CommandLineRunner showDataSource(DataSource ds) {
    return args -> {
      try {
        System.out.println("[DB] URL=" + ds.getConnection().getMetaData().getURL());
        System.out.println("[DB] Driver=" + ds.getConnection().getMetaData().getDriverName());
      } catch (Exception e) { e.printStackTrace(); }
    };
  }
}