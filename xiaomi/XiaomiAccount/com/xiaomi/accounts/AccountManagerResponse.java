package com.xiaomi.accounts;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import com.xiaomi.accounts.IAccountManagerResponse.Stub;

public class AccountManagerResponse implements Parcelable {
    public static final Creator<AccountManagerResponse> CREATOR;
    private static final String TAG = "AccountAuthenticator";
    private IAccountManagerResponse mAccountAuthenticatorResponse;

    public AccountManagerResponse(IAccountManagerResponse response) {
        this.mAccountAuthenticatorResponse = response;
    }

    public AccountManagerResponse(Parcel parcel) {
        this.mAccountAuthenticatorResponse = Stub.asInterface(parcel.readStrongBinder());
    }

    public void onResult(Bundle result) {
        if (Log.isLoggable(TAG, 2)) {
            result.keySet();
            Log.v(TAG, "AccountAuthenticatorResponse.onResult");
        }
        try {
            this.mAccountAuthenticatorResponse.onResult(result);
        } catch (RemoteException e) {
        }
    }

    public void onRequestContinued() {
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "AccountAuthenticatorResponse.onRequestContinued");
        }
        try {
            this.mAccountAuthenticatorResponse.onRequestContinued();
        } catch (RemoteException e) {
        }
    }

    public void onError(int errorCode, String errorMessage) {
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "AccountAuthenticatorResponse.onError: " + errorCode + ", " + errorMessage);
        }
        try {
            this.mAccountAuthenticatorResponse.onError(errorCode, errorMessage);
        } catch (RemoteException e) {
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.mAccountAuthenticatorResponse.asBinder());
    }

    static {
        CREATOR = new Creator<AccountManagerResponse>() {
            public AccountManagerResponse createFromParcel(Parcel source) {
                return new AccountManagerResponse(source);
            }

            public AccountManagerResponse[] newArray(int size) {
                return new AccountManagerResponse[size];
            }
        };
    }
}
