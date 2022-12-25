set -e

dir="./temp/building"
keystore="$dir/bogunov-android-demo.keystore"

trap "rm -f ./temp" EXIT
mkdir -p $dir

echo $SUBGROW_DEMO_STORE_BASE64 | base64 --decode > $keystore
echo $GOOGLE_SERVICES_BASE64 | base64 --decode > ./demo/google-services.json
