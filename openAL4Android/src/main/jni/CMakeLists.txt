cmake_minimum_required(VERSION 3.4.1)

add_library(openalwrapper SHARED
            openalwrapper.c
	    org_pielot_openal_OpenAlBridge.c)

target_include_directories(openalwrapper PRIVATE
	openal/include/)

add_subdirectory(openal)
add_dependencies(openalwrapper OpenAL)

target_link_libraries(openalwrapper
		      OpenAL
                      android
                      log)
