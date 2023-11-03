package ru.skypro.homework.service.MapperUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.user.AuthUserDTO;
import ru.skypro.homework.dto.user.UpdatePasswordDTO;
import ru.skypro.homework.dto.user.UpdateUserDTO;
import ru.skypro.homework.dto.user.UserDTO;
import ru.skypro.homework.entity.User;

import java.net.MalformedURLException;

@Service
@RequiredArgsConstructor
public class UserDTOFactoryImpl implements UserDTOFactory {

    //******************************** пароли  *********************

    @Override
    public UpdateUserDTO fromUserToUpdatePassworDTO(User user) {
        return new UpdateUserDTO(user.getFirstName(), user.getLastName(), user.getPhone());
    }

    @Override
    public User fromUpdatePasswordDTOtoUser(User user, UpdatePasswordDTO updatePasswordDTO) {
        return new User(user.getUsername(), user.getFirstName(), user.getLastName(), user.getRole(), user.getPhone(),
                updatePasswordDTO.getNewPassword(), user.getRegisterDate());
    }

    // **************************** User to UserDTO // UserDTO to User ***************************
    /**
     * Метод преобразует объект класса User в объект класса UserDTO.
     * @param user объект класса User, который будет преобразован.
     * @return объект класса UserDTO, полученный из объекта класса User.
     */
    @Override
    public UserDTO fromUserToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(),
                user.getPhone(), "/users/image/" + user.getId(), user.getRole());
    }

    @Override
    public User fromUserDTOtoUser(UserDTO userDTO) throws MalformedURLException {
        User user = new User();
        return new User(user.getId(), userDTO.getEmail(), user.getPassword(), userDTO.getFirstName(),
                userDTO.getLastName(), userDTO.getPhone(), "/users/image/" + user.getId(), userDTO.getRole(),
                user.getRegisterDate());
    }

    // **************************** User to UpdateUserDTO // UpdateUserDTO to User ***************************
    @Override
    public UpdateUserDTO fromUserToUpdateUserDTO(User user) {
        return new UpdateUserDTO(user.getFirstName(), user.getLastName(), user.getPhone());
    }

    @Override
    public User fromUpdateUserDTOtoUser(UpdateUserDTO updateUserDTO, User user) {
        user.setFirstName(updateUserDTO.getFirstName());
        user.setLastName(updateUserDTO.getLastName());
        user.setPhone(updateUserDTO.getPhone());
        return user;
    }

    // **************************** User to AuthUserDTO // AuthUserDTO to User ***************************
    /**
     * Преобразует объект типа User в объект типа AuthUserDTO.
     * @param user объект типа User, который необходимо преобразовать
     * @return объект типа AuthUserDTO, содержащий информацию о пользователе
     */
    @Override
    public AuthUserDTO fromUserToAuthUserDTO(User user) {
        return new AuthUserDTO(user.getUsername(), user.getPassword(), user.getRole());
    }
    @Override
    public User fromAuthUserDTOtoUser(AuthUserDTO authUserDTO) {
        User user= new User();
        return new User(user.getId(), authUserDTO.getUsername(), authUserDTO.getPassword(), user.getFirstName(),
                user.getLastName(), user.getPhone(), "/users/image/ " + user.getId(), authUserDTO.getRole(),
                user.getRegisterDate());
    }
}