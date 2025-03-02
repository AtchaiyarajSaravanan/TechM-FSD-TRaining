import { Center, HStack, Image } from "@chakra-ui/react";
import logo from "../assets/kanguvaimg.png";
import DarkSwitch from "./DarkSwitch";

function NavBar() {
  return (
    <HStack justifyContent={"space-evenly"} padding={15}>
      <Image src={logo} boxSize={70} alt="Kanguva Logo"></Image>
      <DarkSwitch />
    </HStack>
  );
}
export default NavBar;
