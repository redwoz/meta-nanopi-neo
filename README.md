# meta-nanopi-neo

export TEMPLATECONF=../meta-nanopi-neo/conf

source ./poky/oe-init-build-env test

bitbake neo-console-image

sudo dd if=./tmp/deploy/images/nanopi-neo/neo-console-image-nanopi-neo.sunxi-sdimg of=/dev/disk/by-id/usb-Generic-_USB3.0_CRW-SD_MS_201006010301-0:1 bs=1024
