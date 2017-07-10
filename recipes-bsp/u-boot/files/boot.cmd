if test -z "${mmcpart}"; then setenv mmcpart 5; fi;
setexpr bootcount 0${bootcount} + 1
setexpr bootdelay 0
setenv fdtfile sun8i-h3-nanopi-neo-air.dtb
saveenv

setenv bootargs console=${console} root=/dev/mmcblk0p${mmcpart} rootwait panic=10 ${extra}
load mmc 0:${mmcpart} ${fdt_addr_r} boot/${fdtfile}
load mmc 0:${mmcpart} ${kernel_addr_r} boot/uImage
bootm ${kernel_addr_r} - ${fdt_addr_r}

setexpr bootfail 0${bootfail} + 1
saveenv
reset

