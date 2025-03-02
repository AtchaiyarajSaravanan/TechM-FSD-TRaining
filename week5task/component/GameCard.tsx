import {
  Card,
  CardHeader,
  CardBody,
  CardFooter,
  Image,
  Text,
  Stack,
  Heading,
  Button,
  ButtonGroup,
  Divider,
} from "@chakra-ui/react";

interface GameProps {
  name: string;
  des: string;
  img: string;
  alt: string;
}

function GameCard({ name, des, img, alt }: GameProps) {
  return (
    <Card maxW="sm" borderWidth="1px" borderRadius="lg" overflow="hidden" boxShadow="md">
      <CardBody>
        <Image src={img} alt={alt} borderRadius="lg" />
        <Stack mt="6" spacing="3">
          <Heading size="md">{name}</Heading>
          <Text noOfLines={3}>{des || "No description available."}</Text>
          <Text color="blue.600" fontSize="2xl">
            $45 {/* Replace with actual price if available */}
          </Text>
        </Stack>
      </CardBody>
      <Divider />
      <CardFooter>
        <ButtonGroup spacing="2">
          <Button variant="solid" colorScheme="blue">
            Buy now
          </Button>
          <Button variant="ghost" colorScheme="blue">
            Add to cart
          </Button>
        </ButtonGroup>
      </CardFooter>
    </Card>
  );
}

export default GameCard;
