package edgeservice.service.interfaces;

import edgeservice.controller.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO store(UserDTO user);
    List<UserDTO> findAll();
}
