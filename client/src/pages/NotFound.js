import { Link } from "react-router-dom";
import styled from "styled-components";
import errorImg from "../asset/error.png";

const NotContainer = styled.div`
  width: 100%;
  min-height: 100vh;
  margin-top: -50px;
  background-color: var(--black-050);
`;
const TextContainer = styled.div`
  width: 80%;
  max-width: 1000px;
  min-height: 100vh;
  margin: 0 auto;
  position: relative;
`;
const ImgBox = styled.div`
  background: var(--black-075);
  width: 180px;
  height: 180px;
  border-radius: 50%;
  position: absolute;
  top: 34%;
  left: 15%;
  img {
    width: 120%;
    height: 120%;
    position: absolute;
    bottom: -70px;
    right: -80px;
  }
`;
const TextBox = styled.div`
  position: absolute;
  top: 38%;
  left: 44%;
  h3 {
    font-size: 48px;
    margin-bottom: 20px;
  }
  h5 {
    font-size: 20px;
    margin-bottom: 10px;
  }
  p {
    cursor: pointer;
    color: var(--blue-600);
    :hover {
      color: var(--blue-500);
    }
  }
`;

const NotFound = () => {
  return (
    <NotContainer>
      <TextContainer>
        <ImgBox>
          <img src={errorImg} />
        </ImgBox>
        <TextBox>
          <h3>Page not found !</h3>
          <h5>We're sorry, we couldn't find the page you requested.</h5>
          <Link to={"/"}>
            <p>Please, try again</p>
          </Link>
        </TextBox>
      </TextContainer>
    </NotContainer>
  );
};

export default NotFound;
