package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.wallet.instrumentmanager.R;

public class qq implements Creator<qp> {
    static void a(qp qpVar, Parcel parcel, int i) {
        int bU = b.bU(parcel);
        b.a(parcel, 1, qpVar.getAccountName(), false);
        b.c(parcel, 1000, qpVar.getVersionCode());
        b.a(parcel, 2, qpVar.qD(), false);
        b.J(parcel, bU);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return gG(x0);
    }

    public qp gG(Parcel parcel) {
        String str = null;
        int bT = a.bT(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < bT) {
            int bS = a.bS(parcel);
            switch (a.dk(bS)) {
                case R.styleable.WalletImFormEditText_validatorErrorString /*1*/:
                    str2 = a.p(parcel, bS);
                    break;
                case R.styleable.WalletImFormEditText_validatorRegexp /*2*/:
                    str = a.p(parcel, bS);
                    break;
                case 1000:
                    i = a.g(parcel, bS);
                    break;
                default:
                    a.b(parcel, bS);
                    break;
            }
        }
        if (parcel.dataPosition() == bT) {
            return new qp(i, str2, str);
        }
        throw new a.a("Overread allowed size end=" + bT, parcel);
    }

    public qp[] jh(int i) {
        return new qp[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return jh(x0);
    }
}
