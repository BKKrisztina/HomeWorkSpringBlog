package application.services;
import application.jpaRepos.BlogUserRepo;
import application.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogUserService implements UserDetailsService {

    private BlogUserRepo userRepo;

    private PasswordEncoder pwEncoder;

    private EntityManager em;

    @Autowired
    public BlogUserService(BlogUserRepo userRepo, PasswordEncoder pwEncoder){
        this.userRepo = userRepo;
        this.pwEncoder = pwEncoder;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findBlogUserByUsername(username);
    }

    public BlogUser getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null){
            Object principal = authentication.getPrincipal();
            if(principal instanceof BlogUser){
                return (BlogUser) principal;
            }
        }
        return null;
    }

    @Transactional
    public List<BlogUser> getAllUsers(){
        List<BlogUser> users = userRepo.findAll();
        return users;
    }

    public BlogUser getOneBlogUser(String username){
        try {
            return (BlogUser) loadUserByUsername(username);
        }catch (Exception e){
            return null;
        }
    }
    @Transactional
    public boolean registerUsers(BlogUser user){
        try{
            String userPw = pwEncoder.encode("taCyssup");
            String adminPw = pwEncoder.encode("peehSkcalb");

            BlogUser cicamica = new BlogUser("PussyCat", userPw,"kiscica@citromail.hu", UserRole.USER);
            BlogUser feketebari = new BlogUser("BlackSheep",adminPw,"feketebari@progmatic.hu",UserRole.ADMIN);

            em.persist(cicamica);
            em.persist(feketebari);

        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    public void changePassword(BlogUser user){
            BlogUser userFromDB = (BlogUser) loadUserByUsername(user.getUsername());
            userFromDB.setPassword(user.getPassword());
        }

    @Transactional
    public void changeEmail(BlogUser user){
        BlogUser userFromDB = (BlogUser) loadUserByUsername(user.getEmail());
        userFromDB.setEmail(user.getEmail());
    }
}

