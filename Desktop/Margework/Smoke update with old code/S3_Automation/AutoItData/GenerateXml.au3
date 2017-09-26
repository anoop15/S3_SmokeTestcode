; wait for 5 seconds to appear download and save dialog. Used class property of download dialog.
WinWait("[CLASS:#MozillaDialogClass]","",4)
; Perform keyboard ALT key down + s + ALT key Up action to select Save File Radio button using keyboard sortcut.
Send("{ALTDOWN}s{ALTUP}")
; Wait for 2 seconds
Sleep(2000)
; Press Keyboard ENTER button.
Send("{ENTER}")