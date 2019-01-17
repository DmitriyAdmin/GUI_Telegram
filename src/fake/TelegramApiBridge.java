package fake;

import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;
import org.javagram.response.object.UserContact;
import org.telegram.api.TLUserContact;
import org.telegram.api.TLUserSelf;
import org.telegram.api.auth.TLAuthorization;
import org.telegram.api.engine.RpcException;

import java.io.IOException;
import java.util.ArrayList;

public class TelegramApiBridge
    {
        public TelegramApiBridge(String hostAddr, Integer appId, String appHash) throws IOException
            {

            }

        private static final String REG_NUMBER = "+380955082022";
        private static final String UNREG_NUMBER = "+380667317368";
        private static final String INVITED_NUMBER = "+380633247230";
        private String currentPhone;
        private boolean logedIn;

        private static final String AUTH_CODE = "11111";

        public AuthCheckedPhone authCheckPhone(String phoneNumber) throws IOException
            {
                if(phoneNumber.equals(REG_NUMBER))
                    return new AuthCheckedPhone(true, false);
                else if(phoneNumber.equals(UNREG_NUMBER))
                    return new AuthCheckedPhone(false, false);
                else if(phoneNumber.equals(INVITED_NUMBER))
                    return new AuthCheckedPhone(false, true);
                else
                    throw new RpcException(0, "Phone number invalid");
            }

        public AuthSentCode authSendCode(String phoneNumber) throws IOException
            {
                if(logedIn)
                    throw new RpcException(0, "Invalid Operation");

                AuthCheckedPhone authCheckedPhone = authCheckPhone(phoneNumber);
                currentPhone = phoneNumber;
                return new AuthSentCode(authCheckedPhone.isRegistered(), "");
            }

        public AuthAuthorization authSignIn(String smsCode) throws IOException
            {
                return authSignInOrUp(false, smsCode, "Dmitriy", "Profit");
            }

        private AuthAuthorization authSignInOrUp(boolean up, String smsCode, String firstName, String lastName) throws IOException
            {
                if(logedIn)
                    throw new RpcException(0, "Invalid Operation");

                if(smsCode.equals(AUTH_CODE) && currentPhone != null)
                    {
                        if(authCheckPhone(currentPhone).isRegistered() != up)
                            {
                                TLUserSelf user = new TLUserSelf(1, firstName, lastName, currentPhone, null, null, true);
                                logedIn = true;
                                return new AuthAuthorization(new TLAuthorization(0, user));
                            }
                        else if(up)
                            {
                                throw new RpcException(0, "Invalid Operation");
                            }
                        else
                            {
                                throw new RpcException(0, "Phone number unoccupied");
                            }

                    }
                else if(currentPhone == null)
                    {
                        throw new RpcException(0, "Phone number invalid");
                    }
                else
                    {
                        throw new RpcException(0, "Invalid Code");
                    }
            }

        public AuthAuthorization authSignUp(String smsCode, String firstName, String lastName) throws IOException
            {
                return authSignInOrUp(true, smsCode, firstName, lastName);
            }

        public boolean authLogOut() throws IOException
            {
                if(logedIn)
                    {
                        logedIn = false;
                        return true;
                    }
                else
                    {
                        return logedIn;
                    }
            }

        public ArrayList<UserContact> contactsGetContacts() throws IOException
            {
                ArrayList<UserContact> list = new ArrayList<>();
                list.add(new UserContact(new TLUserContact(2, "Вика", "Профит", 0, "+380996633123", null, null)));
                list.add(new UserContact(new TLUserContact(3, "Таня", "Профит", 0, "+380666633123", null, null)));
                list.add(new UserContact(new TLUserContact(4, "Роман", "Профит", 0, "+380976633123", null, null)));
                list.add(new UserContact(new TLUserContact(5, "Андрей", "Порох", 0, "+380966633123", null, null)));
                list.add(new UserContact(new TLUserContact(6, "Денис", "Тихий", 0, "+380506633123", null, null)));
                return list;
            }


    }
