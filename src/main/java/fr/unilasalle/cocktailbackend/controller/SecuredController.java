package fr.unilasalle.cocktailbackend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cocktails")
public class SecuredController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "✅ Endpoint PUBLIC : tout le monde peut y accéder.";
    }

    @PreAuthorize("hasRole('ROLE_user')")
    @GetMapping("/user")
    public String userEndpoint() {
        return "🔐 Endpoint UTILISATEUR : réservé aux utilisateurs avec le rôle 'user'.";
    }

    @PreAuthorize("hasRole('ROLE_admin')")
    @GetMapping("/admin")
    public String adminEndpoint() {
        return "🛡️ Endpoint ADMIN : réservé aux utilisateurs avec le rôle 'admin'.";
    }
}
