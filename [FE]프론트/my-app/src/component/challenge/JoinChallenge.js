import { useSelector } from "react-redux";
import { api } from "../../api/api";

const JoinChallenge = () => {
  const user = useSelector((state) => state.users);
  // const entranceChallenge = () => {
  //   api
  //     .post(`http://localhost8080/challenge/join/${challenge.id}`, {
  //       headers: {
  //         Authorization: `Bearer ${user.accessToken}`,
  //       },
  //     })
  //     .then((res) => {
  //       console.log(res);
  //     })
  //     .catch((err) => {
  //       console.log(err);
  //     });
  // };

  return;
  // <button id="enter" onClick={entranceChallenge}>
  // 참여하기
  // </button>
};

export default JoinChallenge;
