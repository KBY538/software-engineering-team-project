<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="info-input">
    <div class="" data-option="on">
        <div class="info-input__row campsite">
            <div class="info-input__row-header">캠핑장 이미지 <span class="necessary">*</span></div>
            <%@ include file="../common/ImageUploader.jsp" %>
        </div>

        <div class="info-input__row">
            <div class="info-input__row-header">기본 정보 <span class="necessary">*</span></div>
            <div class="option-input-list">
                <div class="option-wrap">
                    <div class="input-wrap">
                        <div class="input-wrap__input-header">캠핑장 이름</div>
                        <input class="info-input__input" name="campsiteName" type="text" placeholder="캠핑장 이름 입력">
                    </div>
                </div>

                <div class="option-wrap">
                    <div class="input-wrap">
                        <div class="input-wrap__input-header">주소</div>
                        <input class="info-input__input" name="campsiteAddress" type="text" placeholder="주소 입력">
                    </div>
                </div>

                <div class="option-wrap">
                    <div class="input-wrap">
                        <div class="input-wrap__input-header">전화번호</div>
                        <input class="info-input__input" name="campsitePhoneNum" type="text" placeholder="전화번호 입력">
                    </div>
                </div>

                <div class="option-wrap">
                    <div class="input-wrap">
                        <div class="input-wrap__input-header">소개글</div>
                        <textarea class="info-input__input" name="campsiteIntroduction" cols="50" rows="20"
                                  style="height: 80px; resize: none;"></textarea>
                    </div>
                </div>

                <div class="option-wrap">
                    <div class="input-wrap">
                        <div class="input-wrap__input-header">공지사항</div>
                        <textarea class="info-input__input" name="campsiteNotice" cols="50" rows="20"
                                  style="height: 80px; resize: none;"></textarea>
                    </div>
                </div>

            </div>
        </div>

        <div class="info-input__row">
            <div class="info-input__row-header">예약 정보 <span class="necessary">*</span></div>
            <div class="option-input-list">
                <div style="display : flex; flex-direction: row">
                    <div class="option-wrap" data-label="operating" style="margin-right: 50px">
                        <div class="input-wrap">
                            <div class="input-wrap__input-header">운영 형태</div>
                        </div>
                    </div>
                    <br>
                    <div class="option-wrap" data-label="facility">
                        <div class="input-wrap">
                            <div class="input-wrap__input-header">시설</div>
                        </div>
                    </div>
                </div>

                <div style="display : flex; flex-direction: column">
                    <div class="option-wrap">
                        <div class="input-wrap">
                            <div class="input-wrap__input-header">차량 초과 비용</div>
                            <input type="number" name="pricePerExcessCar" class="info-input__input"
                                   placeholder="차량 초과 비용 입력">
                        </div>
                    </div>

                    <div class="option-wrap">
                        <div class="input-wrap">
                            <div class="input-wrap__input-header">인원 초과 비용</div>
                            <input type="number" name="pricePerExcessPerson" class="info-input__input"
                                   placeholder="인원 초과 비용 입력">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="info-input__row">
            <div class="info-input__row-header">방 정보 <span class="necessary">*</span></div>
            <div class="option-input-list">
                <div class="wrap-column normal room">
                    <div class="input-wrap__input-header">방 1</div>

                    <div class="wrap-row" style="display : flex; flex-direction: row">
                        <div class="option-wrap">
                            <div class="input-wrap">
                                <%@ include file="../common/ImageUploader.jsp" %>
                            </div>
                        </div>

                        <div style="display : flex; flex-direction: column; margin-left: 70px">
                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input class="info-input__input" name="name" type="text" placeholder="방 이름 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input type="number" class="info-input__input" name="price" placeholder="가격 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input type="number" class="info-input__input" name="baseHeadCnt"
                                           placeholder="기준 인원 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input type="number" class="info-input__input" name="baseNumCars"
                                           placeholder="기준 차량 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input type="number" class="info-input__input" name="maxHeadCnt"
                                           placeholder="최대 인원 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input type="number" class="info-input__input" name="numRemains"
                                           placeholder="남은 방 개수 입력">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-info add-info">방 추가</button>
            </div>
        </div>

        <div class="info-input__row">
            <div class="info-input__row-header">밀키트 정보</div>
            <div class="option-input-list">
                <div class="wrap-column normal mealKit">
                    <div class="input-wrap__input-header">밀키트 1</div>

                    <div class="wrap-row">
                        <div class="option-wrap">
                            <div class="input-wrap">
                                <%@ include file="../common/ImageUploader.jsp" %>
                            </div>
                        </div>

                        <div style="display : flex; flex-direction: column; margin-left: 70px">
                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input class="info-input__input" name="name" type="text" placeholder="밀키트 이름 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input type="number" class="info-input__input" name="price" placeholder="가격 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input type="number" class="info-input__input" name="numRemains"
                                           placeholder="남은 개수 입력">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-success add-info">밀키트 추가</button>
            </div>
        </div>

        <div class="info-input__row">
            <div class="info-input__row-header">주변 <br>관광지 정보</div>
            <div class="option-input-list">
                <div class="wrap-column normal tourist">
                    <div class="input-wrap__input-header">관광지 1</div>
                    <div class="wrap-row">
                        <div class="option-wrap">
                            <div class="input-wrap">
                                <%@ include file="../common/ImageUploader.jsp" %>
                            </div>
                        </div>

                        <div style="display : flex; flex-direction: column; margin-left: 70px">
                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input class="info-input__input" name="name" placeholder="관광지명 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input class="info-input__input" name="address" placeholder="주소 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <div class="input-wrap__input-header">관광지 소개</div>
                                    <textarea class="info-input__input" name="desc" cols="30" rows="10"
                                              style="resize: none;"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-secondary add-info">관광지 추가</button>
            </div>
        </div>

        <div class="info-input__row">
            <div class="info-input__row-header">주변 <br>맛집 정보</div>
            <div class="option-input-list">
                <div class="wrap-column normal restaurant">
                    <div class="input-wrap__input-header">맛집 1</div>
                    <div class="wrap-row">
                        <div class="option-wrap">
                            <div class="input-wrap">
                                <%@ include file="../common/ImageUploader.jsp" %>
                            </div>
                        </div>

                        <div style="display : flex; flex-direction: column; margin-left: 70px">
                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input class="info-input__input" name="name" placeholder="맛집 이름 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <input class="info-input__input" name="address" placeholder="주소 입력">
                                </div>
                            </div>

                            <div class="option-wrap">
                                <div class="input-wrap">
                                    <div class="input-wrap__input-header">맛집 소개</div>
                                    <textarea class="info-input__input" name="desc" name="" cols="30" rows="10"
                                              style="resize: none;"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-warning add-info">주변 맛집 추가</button>
            </div>
        </div>

        <div class="info-input__row">
            <div class="action">
                <button type="button" class="confirm-button">확인</button>
                <button type="button" class="cancel-button">취소</button>
            </div>
        </div>
    </div>
