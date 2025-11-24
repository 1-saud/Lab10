package com.example.lab10.service;

import com.example.lab10.model.JopApplication;
import com.example.lab10.model.User;
import com.example.lab10.repository.ApplicationRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Data
@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public List<JopApplication> getAllApplication(){
        return applicationRepository.findAll();
    }

    public void AddApplication(JopApplication jopApplication){
        applicationRepository.save(jopApplication);

    }


    public boolean updateApplication(JopApplication jopApplication , Integer Id){
        JopApplication oldJopApplication = applicationRepository.getById(Id);
        if (oldJopApplication == null ){
            return false;
        }
        oldJopApplication.setUserId(jopApplication.getUserId());
        applicationRepository.save(oldJopApplication);
        return true;
    }


    public boolean deleteApplication(Integer Id) {
        JopApplication jopApplication = applicationRepository.getById(Id);
        if (jopApplication == null) {
            return false;
        }
        applicationRepository.delete(jopApplication);
        return true;
    }

}


