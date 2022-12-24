set -e
dir="./temp/building"
keystore="$dir/bogunov-android-demo.keystore"

trap "rm -f $keystore" EXIT
mkdir -p $dir

echo $SUBGROW_DEMO_STORE_BASE64 | base64 --decode > $keystore
#./gradlew :app:bundleRelease
./gradlew :demo:publishBundle
#./gradlew uploadReleasePrivateBundle
rm -r "./temp"
