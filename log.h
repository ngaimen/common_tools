//
// Created by EVAN LOU on 5/17/2017.
//

#ifndef EVAN_LOU_LOG_H
#define EVAN_LOU_LOG_H
#define TAG "EVAN_LOU_TAG"
#include <android/log.h>

#define LOGI(...) \
        __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)

#define LOGD(...) \
        __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)

#define LOGW(...) \
        __android_log_print(ANDROID_LOG_WARN,TAG,__VA_ARGS__)


#endif //EVAN_LOU_LOG_H
