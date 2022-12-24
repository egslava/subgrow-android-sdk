set -e

dir="./temp/building"
keystore="$dir/bogunov-android-demo.keystore"

trap "rm -f $keystore" EXIT
mkdir -p $dir

echo $SUBGROW_DEMO_STORE_BASE64 | base64 --decode > $keystore

#echo $GITHUB_REPOSITORY
#echo $GITHUB_REPOSITORY_GITHUB_REPOSITORY_OWNER
#github_repo_name=`python3 -c "import sys; print(sys.argv[1].split('/')[1])" $GITHUB_REPOSITORY`
#echo 'run id: '$GITHUB_RUN_ID
#export subgrow_sdk_maven_repo="com.github.$GITHUB_REPOSITORY_OWNER:$github_repo_name:v0.0.$GITHUB_RUN_ID.prerelease"

# "v0.0.${{github.run_id}}.prerelease"
#
#echo "subgrow_sdk_maven_repo: " $subgrow_sdk_maven_repo

./gradlew :tutorial:bundleDebug -Dhttp.socketTimeout=600000 -Dhttp.connectionTimeout=600000
