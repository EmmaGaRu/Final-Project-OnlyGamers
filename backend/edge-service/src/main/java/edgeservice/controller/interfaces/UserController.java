package edgeservice.controller.interfaces;

import edgeservice.controller.dto.UserDTO;
import edgeservice.model.User;

import java.util.List;

public interface UserController {
    UserDTO register(UserDTO userDTO);
    List<UserDTO> findAll();
    UserDTO login(User user);
}
