package regex;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class UtilValidatorTest {

    @Test
    public void emailValidator() {
        String correctEmail = "aaa@bbb.net";
        String incorrectEmail = "bbb.com";
        String incorrectEmail1 = "aaa@bbb.net1";
        String incorrectEmail2 = "@bbb.net";
        String incorrectEmail3 = "bbb.net";
        String incorrectEmail4 = "bbb@.net";
        assertTrue(UtilValidator.emailValidator(correctEmail));
        assertFalse(UtilValidator.emailValidator(incorrectEmail));
        assertFalse(UtilValidator.emailValidator(incorrectEmail1));
        assertFalse(UtilValidator.emailValidator(incorrectEmail2));
        assertFalse(UtilValidator.emailValidator(incorrectEmail3));
        assertFalse(UtilValidator.emailValidator(incorrectEmail4));
    }

    @Test
    public void phoneNumbValidator() {
        String correctPhoneNumber = "+38(093)700-03-63";
        String correctPhoneNumber1 = "38(093)700-03-63";
        String correctPhoneNumber2 = "(093)700-03-63";
        String correctPhoneNumber3 = "063-338-63-68";
        String correctPhoneNumber4 = "(093)700-03-63";
        String correctPhoneNumber5 = "050-13-15-555";

        String tooManyAfterLocalCode = "050-13-15-5551";
        String hasLetter = "(093)700-03-63d";
        String tooManyDashes = "(093)7-0-0-03-63";
        String incorrectLocalCode = "(55093)700-03-63";
        String tooShort = "123456";
        String tooLong = "12345678912345678";
        assertFalse(UtilValidator.phoneNumbValidator(tooManyAfterLocalCode));
        assertFalse(UtilValidator.phoneNumbValidator(tooLong));
        assertFalse(UtilValidator.phoneNumbValidator(tooShort));
        assertFalse(UtilValidator.phoneNumbValidator(tooManyDashes));
        assertFalse(UtilValidator.phoneNumbValidator(hasLetter));
        assertFalse(UtilValidator.phoneNumbValidator(incorrectLocalCode));
        assertTrue(UtilValidator.phoneNumbValidator(correctPhoneNumber));
        assertTrue(UtilValidator.phoneNumbValidator(correctPhoneNumber1));
        assertTrue(UtilValidator.phoneNumbValidator(correctPhoneNumber2));
        assertTrue(UtilValidator.phoneNumbValidator(correctPhoneNumber3));
        assertTrue(UtilValidator.phoneNumbValidator(correctPhoneNumber4));
        assertTrue(UtilValidator.phoneNumbValidator(correctPhoneNumber5));
    }

    @Test
    public void dateValidator() {
        String correctDate = "27-03-19";
        String correctDate1 = "27-03-2019";
        String correctDate2 = "27/03/19";
        String correctDate3 = "27.03.2019";
        String lettersInDate = "12-01-201a";
        String tooManySymbols = "12-01-20181";
        String incorrectDayOfMonth = "42-01-18";
        String incorrectMonth = "12-31-2018";
        assertTrue(UtilValidator.dateValidator(correctDate));
        assertTrue(UtilValidator.dateValidator(correctDate1));
        assertTrue(UtilValidator.dateValidator(correctDate2));
        assertTrue(UtilValidator.dateValidator(correctDate3));
        assertFalse(UtilValidator.dateValidator(lettersInDate));
        assertFalse(UtilValidator.dateValidator(tooManySymbols));
        assertFalse(UtilValidator.dateValidator(incorrectDayOfMonth));
        assertFalse(UtilValidator.dateValidator(incorrectMonth));
    }

    @Test
    public void ipValidator() {
        String couldBeYourIp = "12.0.0.256";
        String couldBeYourIp1 = "0.0.0.1";
        String tooManyNumbers = "2117.1.1.19";
        String notEnoughNumbers = "27.03";
        String hasLetter = "27.03.0.a111";
        assertFalse(UtilValidator.ipValidator(hasLetter));
        assertFalse(UtilValidator.ipValidator(notEnoughNumbers));
        assertFalse(UtilValidator.ipValidator(tooManyNumbers));
        assertTrue(UtilValidator.ipValidator(couldBeYourIp));
        assertTrue(UtilValidator.ipValidator(couldBeYourIp1));
    }
}
