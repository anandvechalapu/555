
@SpringBootApplication
public class PasswordResetApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(PasswordResetApplication.class, args);
    }
}

@Controller
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;
 
    @GetMapping("/forgotpassword")
    public String forgotPassword() {
        return "forgotPassword";
    }
 
    @PostMapping("/resetpassword")
    public String resetPassword(@RequestParam("email") String email) {
        passwordResetService.resetPassword(email);
        return "resetPassword";
    }
}

@Service
public class PasswordResetService {
 
    @Autowired
    private PasswordResetRepository passwordResetRepository;
 
    public void resetPassword(String email) {
        // Fetch the user by email
        User user = passwordResetRepository.findByEmail(email);
        // Generate the new password
        String newPassword = generateNewPassword();
        // Set new password to the user
        user.setPassword(encryptPassword(newPassword));
        // Send new password to the user
        sendPasswordResetMail(email, newPassword);
    }
 
    // Generate new password
    private String generateNewPassword() {
        // Your code to generate new password
        return null;
    }
 
    // Encrypt password
    private String encryptPassword(String password) {
        // Your code to encrypt password
        return null;
    }
 
    // Send new password to user's mail
    private void sendPasswordResetMail(String email, String newPassword) {
        // Your code to send mail
    }
}

@Repository
public interface PasswordResetRepository extends JpaRepository<User, Long> {
 
    User findByEmail(String email);
}