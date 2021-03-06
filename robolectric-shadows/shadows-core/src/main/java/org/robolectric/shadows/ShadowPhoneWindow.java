package org.robolectric.shadows;

import android.graphics.drawable.Drawable;
import android.view.Window;
import com.android.internal.policy.PhoneWindow;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.util.ReflectionHelpers.ClassParameter;

import static android.os.Build.VERSION_CODES.M;
import static org.robolectric.internal.Shadow.directlyOn;

/**
 * Shadow for com.android.internal.policy.PhoneWindow.
 */
@Implements(value = PhoneWindow.class, isInAndroidSdk = false, minSdk = M)
public class ShadowPhoneWindow extends ShadowWindow {
  @SuppressWarnings("UnusedDeclaration")
  protected @RealObject Window realWindow;

  @Implementation(minSdk = M)
  public void setTitle(CharSequence title) {
    this.title = title;
    directlyOn(realWindow, realWindow.getClass().getName(), "setTitle", ClassParameter.from(CharSequence.class, title));
  }

  @Implementation(minSdk = M)
  public void setBackgroundDrawable(Drawable drawable) {
    this.backgroundDrawable = drawable;
    directlyOn(realWindow, realWindow.getClass().getName(), "setBackgroundDrawable", ClassParameter.from(Drawable.class, drawable));
  }
}
