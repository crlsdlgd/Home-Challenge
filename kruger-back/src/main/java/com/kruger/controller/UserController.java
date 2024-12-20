package com.kruger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import com.kruger.dto.UserDTO;
import com.kruger.models.User;
import com.kruger.service.UserService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService service;
	private final GeometryFactory geometryFactory = new GeometryFactory();
	
	@GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }
	
	@PostMapping("/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
	    if (user.getFirstName() == null || user.getEmail() == null) {
	        return ResponseEntity.badRequest().body(null);
	    }
	    return ResponseEntity.ok(service.saveUser(user));
	}
	
//	@PutMapping("/user/update")
//	public ResponseEntity<User> updateUser(@RequestBody User user) {
//	    return ResponseEntity.ok(service.updateUser(user));
//	}
	
//	@PutMapping("/user/update")
//	public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO) {
//        // Convertir DTO a la entidad User
//        User user = new User();
//        user.setId(userDTO.getId());
//        user.setFirstName(userDTO.getFirstName());
//        user.setLastName(userDTO.getLastName());
//        user.setCedula(userDTO.getCedula());
//        user.setEmail(userDTO.getEmail());
//        user.setRole(userDTO.getRole());
//        // Convertir LocationDTO a Point
//        UserDTO.LocationDTO location = userDTO.getLocation();
//        if (location != null) {
//            Point point = geometryFactory.createPoint(new Coordinate(location.getLng(), location.getLat()));
//            point.setSRID(4326);
////            user.setLocation(point);
//        }
//
//        // Llamar al servicio para actualizar el usuario
//        return ResponseEntity.ok(service.updateUser(user));
		

//	}
	
	@PostMapping("/user/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
	    if (user.getFirstName() == null || user.getEmail() == null) {
	        return ResponseEntity.badRequest().body(null);
	    }
	    return ResponseEntity.ok(service.saveUser(user));
	}
	
	@GetMapping("/user/info")
    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
		if (principal != null) {
	        String email = principal.getAttribute("email");
	        User user = service.getOrCreateUser(email);
	        return ResponseEntity.ok(user);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
	    }
    }
}
