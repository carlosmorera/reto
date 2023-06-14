package com.example.demo.service;

import com.example.demo.DAO.IUser;
import com.example.demo.DTO.MapperUtility;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.DocumentType;
import com.example.demo.model.User;
import com.example.demo.model.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUser Iuser;

    private static final String VALID_USER = "23445322";
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public Optional<UserResponse> getUserById(String documentNumber) {
        logger.info("Consultando usuario");
        return VALID_USER.equals(documentNumber) ? Optional.of(MapperUtility.buildUserResponse()) : Optional.empty();
    }

    @Override
    public Optional<User> add(UserDTO userDTO) throws Exception {
        logger.info("Agregando un nuevo usuario");
        User user = MapperUtility.buildUserFromDto(userDTO);
        boolean documentTypeValidated = user.getDocumentType().equals(DocumentType.C.toString()) || user.getDocumentType().equals(DocumentType.P.toString()) ;
        if (documentTypeValidated) {
            return Iuser.add(user);
        } else {
            logger.info("Hubo un error al guardar el usuario");
            throw new Exception("Tipo de documento invalido ");
        }
    }


}
