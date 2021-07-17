TARGET_PLATFORM := android-3
ROOT_PATH := $(call my-dir)


#$(call import-module,prefab/openal)

########################################################################################################

include $(CLEAR_VARS)

LOCAL_MODULE     := openalwrapper
LOCAL_ARM_MODE   := arm
LOCAL_PATH       := $(ROOT_PATH)
LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../../../openal/src/main/jni/include
LOCAL_SRC_FILES  := openalwrapper.c 							\
					org_pielot_openal_OpenAlBridge.c 	\
					
LOCAL_LDLIBS     := -llog -Wl,-s

#LOCAL_SHARED_LIBRARIES := libopenal

include $(BUILD_SHARED_LIBRARY)

########################################################################################################

