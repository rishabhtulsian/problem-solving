import java.util.Set;
import java.util.HashSet;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            uniqueEmails.add(normalize(email));
        }
        return uniqueEmails.size();
    }

    private String normalize(String email) {
        String[] parts = email.split("@");
        parts[0] = parts[0].split("\\+")[0];
        parts[0] = parts[0].replaceAll("\\.", "");
        return parts[0] + "@" + parts[1];
    }
}