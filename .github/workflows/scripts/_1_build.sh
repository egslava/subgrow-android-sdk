source $(dirname "$0")/_0_configure.sh

./gradlew :tutorial:bundle :tutorial:assemble :ui_debugger:assemble :demo:bundle :demo:assemble
