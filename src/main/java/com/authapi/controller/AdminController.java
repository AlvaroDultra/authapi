package com.authapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // 🔒 Somente usuários com ROLE_ADMIN podem acessar este endpoint
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAllUsers() {
        return "✅ Acesso permitido: você é ADMIN!";
    }

    // 🔒 Outro endpoint restrito a administradores
    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable Long id) {
        return "Usuário " + id + " removido (somente ADMIN pode fazer isso)";
    }

    // 🔓 Endpoint livre, só pra teste
    @GetMapping("/public")
    public String publicAccess() {
        return "🌍 Endpoint público — qualquer um pode acessar";
    }
}
