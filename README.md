# SnackbarBug

## Steps to reproduce:
1. Create a Snackbar and reference it in an Activity
2. Don't call Snackbar.show()
3. Open and close the Activity
4. Notice that the Activity is not garbage collected because snackbar has a reference to it

## Cause of the bug
`AccessibilityManagerCompat.addTouchExplorationStateChangeListener()` is called in the constructor of `SnackbarBaseLayout` while `AccessibilityManagerCompat.removeTouchExplorationStateChangeListener()` is called in `SnackbarBaseLayout.onDetachedFromWindow()`. So `removeTouchExplorationStateChangeListener()` is never called if `Snackbar.show()` is never called. Therefore, `touchExplorationStateChangeListener` is added to `AccessibilityManager` without being removed.

## Solution 1
Update to AndroidX and use `com.google.android.material.snackbar.Snackbar` instead.

## Solution 2
Do not create the Snackbar unless you are ready to show it.
