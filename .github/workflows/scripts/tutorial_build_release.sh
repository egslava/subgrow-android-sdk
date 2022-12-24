set -e
github_repo_name=`python -c "import sys; print(sys.argv[1].split('/')[1])" GITHUB_REPOSITORY`
$GITHUB_RUN_ID
export subgrow_sdk_maven_repo="com.github.$GITHUB_REPOSITORY_OWNER:$github_repo_name:0.0.$LAST_GITHUB_TAG"

./gradlew :tutorial:bundleRelease -Dhttp.socketTimeout=600000 -Dhttp.connectionTimeout=600000
./gradlew :tutorial:assembleRelease
./gradlew :tutorial:assembleDebug
rm -r "./temp"
