TARGET_PLATFORM := android-3
ROOT_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := libopenal
# We only have armeabi...
# LOCAL_SRC_FILES := $(ROOT_PATH)/../jniLibs/$(TARGET_ARCH_ABI)/libopenal.so
LOCAL_SRC_FILES := $(ROOT_PATH)/../jniLibs/armeabi/libopenal.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE     := openalwrapper
LOCAL_ARM_MODE   := arm
LOCAL_PATH       := $(ROOT_PATH)
LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../../../openal-includes
LOCAL_SRC_FILES  := openalwrapper.c org_pielot_openal_OpenAlBridge.c
					
LOCAL_LDLIBS     := -llog -Wl,-s

LOCAL_SHARED_LIBRARIES := libopenal

include $(BUILD_SHARED_LIBRARY)
