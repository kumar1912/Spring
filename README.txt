https://www.dineshonjava.com/microservices-inter-service-communication/        Interview
https://www.baeldung.com/spring-webclient-resttemplate           Interview

https://teachmeonline.net/unit/11-using-resttemplate-to-call-an-external-microservice-api-spring-boot-microservices-level-1/

https://www.tutorialspoint.com/spring_boot/spring_boot_rest_template.htm

https://www.javadream.in/resttemplate-in-spring-boot-microservice/             Code Available 

@Transactional
public class AuditEventService {

 /** Create a new role  */
    @Transactional
    public ResponseEntity<Object> addRole(Role role)  {

        Role newRole = new Role();
        newRole.setRoleName(role.getRoleName());
        newRole.setPermission(role.getPermission());
        List<Role> roleList = new ArrayList<>();
        roleList.add(newRole);
        for(int i=0; i< role.getUsers().size(); i++){
            if(!userRepository.findByEmail(role.getUsers().get(i).getEmail()).isPresent()) {
                User newUser = role.getUsers().get(i);
                newUser.setRoles(roleList);
                User savedUser = userRepository.save(newUser);
                
                if(! userRepository.findById(savedUser.getUserId()).isPresent())
                    return ResponseEntity.unprocessableEntity().body("Role Creation Failed");
            }
             else  return   ResponseEntity.unprocessableEntity().body("User with email Id is already Present");
        }
        return ResponseEntity.ok("Successfully created Role");
    }
	
	
	 @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthoritiesByLogin(String login) {
        return userRepository.findOneWithAuthoritiesByLogin(login);
    }
