# OpenAL for Android Sample
At this point, it is hard to find some working examples of 3D audio/spatialization on the Android platform that could be easily prototyped. @manfreddiaz shared this sample application showing 3D audio rendering, using the bit old [openAL4android](http://pielot.org/2011/11/openal4android-2/) library, however, it was using various deprecated functions, prebuilt libraries and more. I adapted it to:
- Source-build OpenAL (openalsoft) and OpenALwrapper
- Updated SDK & NDK
- Migrated to AndroidX
- Other housekeeping

Hope it helps!
  

## Ready for

* Android SDK v30.0.2
* Android Studio v4.x
* Gradle Plugin v4.2.x
* Tested On: *Android 11.0*

## Remarks

* **IMPORTANT**: to make a compatible *.wav* file, the *RIFF WAVE* headers should be present on the file.
  Common audio/video conversion libraries tried (sox, ffmpeg) does not trivially generate the proper *.wav* file headers. Only [Audacity](http://www.audacityteam.org/download/windows/) for Windows 10 did the trick.  
