#!/usr/bin/env bash

## LOCAL: vars
echo '------------------------------------------------------------------'
echo 'Create the BACKUP files of "SRC" folder and "settings.gradle" file'
echo '------------------------------------------------------------------'
mv src BACKUP_src
mv settings.gradle BACKUP_settings.gradle

mkdir modules/
mkdir JMeterScripts/

echo '---------------------------------------------------------------'
echo 'Create the "TEMP" configuration'
echo '---------------------------------------------------------------'
mkdir -p temp/
cd temp
git clone https://manoelcyreno@bitbucket.org/gs-br/frw-tests-samples.git

echo '---------------------------------------------------------------'
echo 'Create the "SAMPLES" codes'
echo '---------------------------------------------------------------'
cp -r frw-tests-samples/modules/* ../modules/
cp -rf frw-tests-samples/settings.gradle ../settings.gradle

echo '---------------------------------------------------------------'
echo 'Create the "JMeter Scripts" samples codes'
echo '---------------------------------------------------------------'
cp -r frw-tests-samples/JMeterScripts/* ../JMeterScripts/

echo '---------------------------------------------------------------'
echo 'Create the "JMeter Scripts" samples codes'
echo '---------------------------------------------------------------'
cp frw-tests-samples/Jenkinsfile.TEMPLATE ../

echo '---------------------------------------------------------------'
echo 'Remove the "TEMP" configuration'
echo '---------------------------------------------------------------'
cd ..
rm -rf temp/