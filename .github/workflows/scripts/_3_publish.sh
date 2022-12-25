source $(dirname "$0")/_0_configure.sh

#./gradlew :app:bundleRelease
./gradlew :demo:publishReleaseBundle
#./gradlew uploadReleasePrivateBundle
