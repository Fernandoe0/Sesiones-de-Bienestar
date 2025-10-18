/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.audit;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author BICHO
 */
public class AuditAspect {
    
    private final AuditLogRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public AuditAspect(AuditLogRepository repo) {
        this.repo = repo;
    }
    
    @AfterReturning(pointcut = "@annotation(gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.audit.Auditable)",
            returning = "result")
    public void afterAuditable(JoinPoint jp, Object result) {
        MethodSignature sig = (MethodSignature) jp.getSignature();
        Auditable ann = sig.getMethod().getAnnotation(Auditable.class);
        
        String username = "ANON";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getName() != null) username = auth.getName();
        
        String details;
        try {details = mapper.writeValueAsString(jp.getArgs());}
        catch (Exception e) { details = "argsToString";}
        
        AuditLog log = new AuditLog();
        log.setUsername(username);
        log.setOperation(ann.value().isEmpty()? sig.getMethod().getName() : ann.value());
        log.setTimestamp(LocalDateTime.now());
        log.setDetails(details);
        repo.save(log);
    }
}
