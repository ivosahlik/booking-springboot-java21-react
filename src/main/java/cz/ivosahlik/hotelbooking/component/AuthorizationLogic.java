package cz.ivosahlik.hotelbooking.component;

import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("authz")
public class AuthorizationLogic {

    public boolean decide(MethodSecurityExpressionOperations operations) {
        Authentication authentication = operations.getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }
        if (authentication.getPrincipal() instanceof UserDetails userDetails &&
                (!userDetails.isAccountNonLocked() || !userDetails.isAccountNonExpired())) {
            return false;
        }
        if (hasRole(authentication, "ROLE_SPECIFIC")) {
            return true;
        }
        if (hasPermission(authentication, "SPECIFIC_PERMISSION")) {
            return true;
        }
        if (hasAttribute(authentication, "SPECIFIC_ATTRIBUTE")) {
            return true;
        }
        if (isValidTokenOrHash(authentication)) {
            return true;
        }

        return false;
    }

    private boolean hasRole(Authentication authentication, String role) {
        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(role));
    }

    private boolean hasPermission(Authentication authentication, String permission) {
        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(permission));
    }

    private boolean hasAttribute(Authentication authentication, String attribute) {
        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(attribute));
    }

    private boolean isValidTokenOrHash(Authentication authentication) {

        String tokenOrHash = (String) authentication.getCredentials();
        return validateTokenOrHash(tokenOrHash);
    }

    private boolean validateTokenOrHash(String tokenOrHash) {
        return "VALID_TOKEN_OR_HASH".equals(tokenOrHash);
    }

}
