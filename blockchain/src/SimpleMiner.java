import java.security.MessageDigest;

public class SimpleMiner {
    public static void main(String[] args) throws Exception {
        String blockData = "Alice pays Bob 5 BTC";  // Fake block content
        int nonce = 0;
        String hash = "";

        // Target: hash must start with "00" (VERY EASY compared to real Bitcoin)
        String targetPrefix = "000000";

        while (true) {
            String input = blockData + nonce;
            hash = sha256(input);

            if (hash.startsWith(targetPrefix)) {
                System.out.println("🎉 Block mined!");
                System.out.println("Nonce: " + nonce);
                System.out.println("Hash: " + hash);
                break;
            }

            nonce++;
        }
    }

    public static String sha256(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes("UTF-8"));

        // Convert the byte array into a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
