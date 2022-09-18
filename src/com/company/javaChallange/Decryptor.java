package com.company.javaChallange;

import java.util.List;

public class Decryptor {
    public void decrypt(List collection) {
        int hashCode = collection.hashCode();
        final String secretKey = String.valueOf(hashCode);

        String originalString = "q37amlPPfxutMBe0SMWwDzNLJe6lpNOiPIPtNvX5nizw7ttdiK7quCztCdeeWRxKEq/LPkgqIIUpPAwWYtx+0KltVP56k6Ldsqnqkkj2jhOJcRs1r+a/j3wgrJsEq/yWPNWatXuerhsSCmdvA1XrM7UrU9fnhcBB+keqc45+LY01f/I7YzP+ZxjZOCGoey5B0izVZjUGSgVz6u+2swQyaf/eBle9bggM7XEFsRcpOFA=";
        String decryptedString = AES.decrypt(originalString, secretKey);

        System.out.println(decryptedString);
    }
}
