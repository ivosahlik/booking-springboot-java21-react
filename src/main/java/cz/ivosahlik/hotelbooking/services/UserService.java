package cz.ivosahlik.hotelbooking.services;

import cz.ivosahlik.hotelbooking.dtos.LoginRequest;
import cz.ivosahlik.hotelbooking.dtos.RegistrationRequest;
import cz.ivosahlik.hotelbooking.dtos.Response;
import cz.ivosahlik.hotelbooking.dtos.UserDTO;
import cz.ivosahlik.hotelbooking.entities.User;

public interface UserService {

    Response registerUser(RegistrationRequest registrationRequest);
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    Response getOwnAccountDetails();
    User getCurrentLoggedInUser();
    Response updateOwnAccount(UserDTO userDTO);
    Response deleteOwnAccount();
    Response getMyBookingHistory();
}
