package net.Soumik.Paul.service;

import net.Soumik.Paul.entity.PaulEntry;
import net.Soumik.Paul.entity.User;
import net.Soumik.Paul.repository.PaulEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class PaulEntryService {

    @Autowired
    private PaulEntryRepository paulEntryRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(PaulEntry paulEntry, String userName){
        try {
            User user = userService.findByUserName(userName);
            paulEntry.setDate(LocalDateTime.now());
            PaulEntry saved = paulEntryRepository.save(paulEntry);
            user.getPaulEntries().add(saved);
            userService.saveUser(user);
        }
        catch (Exception e) {
            System.out.print(e);
            throw new RuntimeException("An error occurred while saving entry."+e);
        }

    }

    public void saveEntry(PaulEntry paulEntry){
        paulEntryRepository.save(paulEntry);
    }

    public List<PaulEntry> getAll(PaulEntry myEntry){
        return paulEntryRepository.findAll();
    }

    public Optional<PaulEntry> findById(ObjectId id){
        return paulEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName){
        boolean removed = false;
      try{
        User user = userService.findByUserName(userName);
        removed = user.getPaulEntries().removeIf(x -> x.getId().equals(id));
        if(removed){
            userService.saveUser(user);
            paulEntryRepository.deleteById(id);
        }
    }
      catch(Exception e){
          System.out.print(e);
          throw new RuntimeException("An error occurred while deleting entry.",e);
      }
      return removed;
    }

    public List<PaulEntry> findByUserName(String userName){
        return null;
    }


}
