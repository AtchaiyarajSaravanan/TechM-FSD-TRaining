import { HStack, Switch, useColorMode } from "@chakra-ui/react";
function DarkSwitch() {
  let { colorMode, toggleColorMode } = useColorMode();
  return (
    <HStack>
      <Switch
        colorScheme="red"
        isChecked={colorMode == "dark"}
        onChange={toggleColorMode}
      >
        DarkSwitch
      </Switch>
    </HStack>
  );
}
export default DarkSwitch;
